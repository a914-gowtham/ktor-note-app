package com.example.routes

import com.example.auth.JwtService
import com.example.db.daos.UserDao
import com.example.db.model.LoginRequest
import com.example.db.model.RegisterRequest
import com.example.db.model.SimpleResponse
import com.example.db.model.User
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

const val API_VERSION = "/v1"
const val USERS = "$API_VERSION/users"
const val REGISTER_REQUEST = "$USERS/register"
const val LOGIN_REQUEST = "$USERS/login"

@Location(REGISTER_REQUEST)
class UserRegisterRoute

@Location(LOGIN_REQUEST)
class UserLoginRoute

fun Route.UserRoutes(
    userDao: UserDao,
    jwtService: JwtService,
    hashFunction: (String) -> String
) {

    post<UserRegisterRoute> {
        val registerRequest = try {
            call.receive<RegisterRequest>()
        } catch (e: Exception) {
            call.respond(
                HttpStatusCode.BadRequest, SimpleResponse(
                    false,
                    "Missing field error "
                )
            )
            return@post
        }

        try {
            val user = User(
                registerRequest.email,
                hashFunction(registerRequest.password),
                registerRequest.name
            )
            userDao.insertUser(user)
            call.respond(
                HttpStatusCode.OK, SimpleResponse(
                    true,
                    jwtService.generateToken(user)
                )
            )
        } catch (e: Exception) {
            call.respond(
                HttpStatusCode.Conflict, SimpleResponse(
                    false,
                    e.message ?: "Some error occurred"
                )
            )
            return@post
        }
    }

    post<UserLoginRoute> {
        val loginRequest = try {
            call.receive<LoginRequest>()
        } catch (e: Exception) {
            call.respond(
                HttpStatusCode.BadRequest, SimpleResponse(
                    false,
                    "Missing field error ${e.message}"
                )
            )
            return@post
        }

        try {
            val user = userDao.getUserByEmail(loginRequest.email)
            if (user == null) {
                call.respond(
                    HttpStatusCode.BadRequest, SimpleResponse(
                        false,
                        "No user found"
                    )
                )
            } else if (user.hashPwd == hashFunction(loginRequest.password))
                call.respond(
                    HttpStatusCode.OK, SimpleResponse(
                        true,
                        jwtService.generateToken(user)
                    )
                )
            else {
                call.respond(
                    HttpStatusCode.BadRequest, SimpleResponse(
                        false,
                        "Password is incorrect"
                    )
                )
            }
        } catch (e: Exception) {
            call.respond(
                HttpStatusCode.Conflict, SimpleResponse(
                    false,
                    e.message ?: "Some error occurred"
                )
            )
            return@post
        }
    }

}