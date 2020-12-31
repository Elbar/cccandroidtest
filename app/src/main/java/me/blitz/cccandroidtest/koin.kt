import androidx.room.Room
import me.blitz.cccandroidtest.AppRepository
import me.blitz.cccandroidtest.db.AppDatabase
import me.blitz.cccandroidtest.repository.EstimateRepository
import me.blitz.cccandroidtest.repository.PersonRepository
import org.koin.dsl.module

val mainModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "cc_android_db")
            .fallbackToDestructiveMigration()
            .build()
    }
    single { EstimateRepository(get()) }
    single { PersonRepository(get()) }
    single { AppRepository(get()) }
}