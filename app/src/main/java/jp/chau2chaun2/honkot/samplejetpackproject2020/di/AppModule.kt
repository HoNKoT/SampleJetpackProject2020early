package jp.chau2chaun2.honkot.samplejetpackproject2020.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import jp.chau2chaun2.honkot.samplejetpackproject2020.db.Repo
import jp.chau2chaun2.honkot.samplejetpackproject2020.db.SampleRepo

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    @Provides
    fun provideRepo(@ApplicationContext context: Context): Repo {
        return SampleRepo(context)
    }
}
