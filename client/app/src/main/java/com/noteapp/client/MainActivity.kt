package com.noteapp.client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.noteapp.client.navigation.Screens
import com.noteapp.client.ui.theme.TAppTheme
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.gowtham.login.LoginScreen
import com.gowtham.login.LoginViewModel
import com.gowtham.register.RegisterScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavigation()
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation() {
    val navController = rememberAnimatedNavController()

    val screenWidth = with(LocalDensity.current) {
        LocalConfiguration.current.screenWidthDp.dp.roundToPx()
    }
    AnimatedNavHost(
        navController = navController,
        startDestination = Screens.LoginScreen.route,
        enterTransition = { initial, _ ->
            slideInHorizontally(
                initialOffsetX = { screenWidth },
                animationSpec = tween(800)
            ) + fadeIn(
                initialAlpha = 0.5f,
                animationSpec = tween(800)
            )
        },
        exitTransition = { _, target ->
            slideOutHorizontally(
                targetOffsetX = { -screenWidth },
                animationSpec = tween(800)
            ) + fadeOut(
                targetAlpha = 0.5f,
                animationSpec = tween(800)
            )
        },
        popEnterTransition = { initial, _ ->
            slideInHorizontally(
                initialOffsetX = { -screenWidth },
                animationSpec = tween(800)
            ) + fadeIn(
                initialAlpha = 0.5f,
                animationSpec = tween(800)
            )
        },
        popExitTransition = { _, target ->
            slideOutHorizontally(
                targetOffsetX = { screenWidth },
                animationSpec = tween(800)
            ) + fadeOut(
                targetAlpha = 0.5f,
                animationSpec = tween(800)
            )
        },
    ){

        composable(Screens.LoginScreen.route,
            ){
            val viewModel: LoginViewModel = hiltViewModel()
            LoginScreen(viewModel = viewModel) {
                navController.navigate(Screens.RegisterScreen.route)
            }
        }

        composable(Screens.RegisterScreen.route){
            RegisterScreen{
                navController.popBackStack()
            }
        }
    }

}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TAppTheme {
        Greeting("Android")
    }
}

const val ANIMATION_DURATION = 300
const val ANIMATION_OFFSET = 1000

@ExperimentalAnimationApi
fun enterTransition(desRoute: String, initial: NavBackStackEntry): EnterTransition? {
    return when (initial.destination.route) {
        desRoute ->
            slideInHorizontally(
                initialOffsetX = { ANIMATION_OFFSET },
                animationSpec = tween(ANIMATION_DURATION)
            ) + fadeIn(animationSpec = tween(ANIMATION_DURATION))
        else -> null
    }
}

@ExperimentalAnimationApi
fun exitTransition(desRoute: String, target: NavBackStackEntry): ExitTransition? {
    return when (target.destination.route) {
        desRoute ->
            slideOutHorizontally(
                targetOffsetX = { -ANIMATION_OFFSET },
                animationSpec = tween(ANIMATION_DURATION)
            ) + fadeOut(animationSpec = tween(ANIMATION_DURATION))
        else -> null
    }
}

@ExperimentalAnimationApi
fun popEnterTransition(desRoute: String, initial: NavBackStackEntry): EnterTransition? {
    return when (initial.destination.route) {
        desRoute ->
            slideInHorizontally(
                initialOffsetX = { -ANIMATION_OFFSET },
                animationSpec = tween(ANIMATION_DURATION)
            ) + fadeIn(animationSpec = tween(ANIMATION_DURATION))
        else -> null
    }
}

@ExperimentalAnimationApi
fun popExitAnimation(desRoute: String, target: NavBackStackEntry): ExitTransition? {
    return when (target.destination.route) {
        desRoute ->
            slideOutHorizontally(
                targetOffsetX = { ANIMATION_OFFSET },
                animationSpec = tween(ANIMATION_DURATION)
            ) + fadeOut(animationSpec = tween(ANIMATION_DURATION))
        else -> null
    }
}

