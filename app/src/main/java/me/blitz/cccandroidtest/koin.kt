import android.content.Context
import androidx.room.Room
import me.blitz.cccandroidtest.db.AppDatabase
import me.blitz.cccandroidtest.repository.EstimateRepository
import me.blitz.cccandroidtest.repository.PersonRepository
import me.blitz.cccandroidtest.ui.main.MainViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val mainModule = module {
    single {
        Room.databaseBuilder(get<Context>(), AppDatabase::class.java, "cc_android_db")
            .fallbackToDestructiveMigration()
            .build()
    }
    single { EstimateRepository(get()) }
    single { PersonRepository(get()) }
    viewModel { MainViewModel(get(), get()) }
}