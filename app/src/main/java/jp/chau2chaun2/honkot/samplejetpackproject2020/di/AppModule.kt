package jp.chau2chaun2.honkot.samplejetpackproject2020.di

import dagger.Module
import dagger.Provides
import jp.chau2chaun2.honkot.samplejetpackproject2020.CustomApplication
import jp.chau2chaun2.honkot.samplejetpackproject2020.db.Repo
import jp.chau2chaun2.honkot.samplejetpackproject2020.db.SampleRepo
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRepo(app: CustomApplication): Repo {
        return SampleRepo(app)
    }
}
