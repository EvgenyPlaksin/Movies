package com.ajdi.yassin.popularmoviespart1.ui.movieslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajdi.yassin.popularmoviespart1.data.api.NetworkState;
import com.ajdi.yassin.popularmoviespart1.databinding.ItemNetworkStateBinding;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.ajdi.yassin.popularmoviespart1.data.api.Status.FAILED;
import static com.ajdi.yassin.popularmoviespart1.data.api.Status.RUNNING;

/**
 * ViewHolder, который может отображать загрузку или действие щелчка.
 */
public class NetworkStateViewHolder extends RecyclerView.ViewHolder {

    private ItemNetworkStateBinding binding;

    public NetworkStateViewHolder(@NonNull ItemNetworkStateBinding binding,
                                  final MoviesViewModel viewModel) {
        super(binding.getRoot());
        this.binding = binding;

        // повтор при нажатии
        binding.retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.retry();
            }
        });
    }

    static NetworkStateViewHolder create(ViewGroup parent, MoviesViewModel viewModel) {
        // Inflate
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // привязка
        ItemNetworkStateBinding binding =
                ItemNetworkStateBinding.inflate(layoutInflater, parent, false);
        return new NetworkStateViewHolder(binding, viewModel);
    }

    void bindTo(NetworkState networkState) {
        binding.progressBar.setVisibility(
                isVisible(networkState.getStatus() == RUNNING));
        binding.retryButton.setVisibility(
                isVisible(networkState.getStatus() == FAILED));
        binding.errorMsg.setVisibility(
                isVisible(networkState.getMsg() != null));
        binding.errorMsg.setText(networkState.getMsg());
    }

    private int isVisible(boolean condition) {
        if (condition)
            return View.VISIBLE;
        else
            return View.GONE;
    }
}
