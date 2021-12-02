package com.ajdi.yassin.popularmoviespart1.ui.movieslist;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajdi.yassin.popularmoviespart1.data.model.Movie;
import com.ajdi.yassin.popularmoviespart1.databinding.ItemMovieBinding;
import com.ajdi.yassin.popularmoviespart1.ui.moviedetails.DetailsActivity;
import com.ajdi.yassin.popularmoviespart1.utils.GlideRequests;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.ajdi.yassin.popularmoviespart1.utils.Constants.IMAGE_URL;


public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final ItemMovieBinding binding;
    private GlideRequests glide;

    public MovieViewHolder(@NonNull ItemMovieBinding binding, GlideRequests glide) {
        super(binding.getRoot());

        this.binding = binding;
        this.glide = glide;
    }

    void bindTo(final Movie movie) {

        // постеры фильмов
        glide
                .load(IMAGE_URL + movie.getImageUrl())
                .placeholder(android.R.color.holo_red_dark)
                .into(binding.imageMoviePoster);

        // он клик событие
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.EXTRA_MOVIE_ID, movie.getId());
                view.getContext().startActivity(intent);
            }
        });

        binding.executePendingBindings();
    }

    static MovieViewHolder create(ViewGroup parent, GlideRequests glide) {
        // надуть
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // создать привязку
        ItemMovieBinding binding =
                ItemMovieBinding.inflate(layoutInflater, parent, false);
        return new MovieViewHolder(binding, glide);
    }
}
