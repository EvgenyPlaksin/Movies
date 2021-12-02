package com.ajdi.yassin.popularmoviespart1.utils;

import com.ajdi.yassin.popularmoviespart1.data.MovieRepository;
import com.ajdi.yassin.popularmoviespart1.data.api.ApiClient;

/**
 * Класс, который обрабатывает создание объекта.
 */
public class Injection {

    /**
     * создание репрозитория
     */
    public static MovieRepository provideMovieRepository() {
        return new MovieRepository(ApiClient.getInstance(), AppExecutors.getInstance());
    }
}
