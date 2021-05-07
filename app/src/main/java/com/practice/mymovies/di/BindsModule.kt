package com.practice.mymovies.di

import com.practice.mymovies.data.repository.MovieRepository
import com.practice.mymovies.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class BindsModule {
    @Binds
    @Singleton
    abstract fun bindRepository(impl: MovieRepositoryImpl): MovieRepository
}
