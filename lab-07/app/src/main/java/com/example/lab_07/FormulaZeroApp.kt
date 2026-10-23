
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab_07.DriversScreen
import com.example.lab_07.UpcomingRacesScreen
import com.example.lab_7.HomeScreen

@Composable
fun FormulaZeroApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("races") { UpcomingRacesScreen(navController) }
        composable("drivers") { DriversScreen(navController) }
    }
}