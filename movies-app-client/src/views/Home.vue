<template>
    <main class="container mt-2">
        <form @submit.prevent="getResults" class="container mt-5 mb-5 mx-auto">
            <div class="input-group">
                <input v-model="searchTerm" id="searchTerm" type="text" class="form-control"
                       placeholder="Enter a movie name" aria-label="Search">
                <div class="input-group-btn">
                    <button class="btn btn-outline-warning ml-3" type="submit">Search</button>
                </div>
            </div>
        </form>
        <div v-if="movies.length">
            <div class="container">
                <div v-if="error" class="alert alert-danger col" role="alert">
                    {{error}}
                </div>
            </div>
            <div v-if="!error" class="">
                <div class=" card-deck" id="results">
                    <div :key="movie.id" v-for="movie in movies" class="col-4">
                        <router-link class="text-decoration-none" :to="{ name: 'Movie', params: { id: movie.id } }">
                            <div class="card mb-5" style="width: 20rem;">
                                <img :src="movie.image" class="card-img-top movie-card-img py-2 px-2 shadow-lg" :alt="movie.name">
                                <div class="card-body text-wrap movie-card-name">
                                    <h5 class="card-title">{{movie.name}}</h5>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">{{movie.year}}</small>
                                </div>
                            </div>
                        </router-link>
                    </div>
                </div>
            </div>
        </div>
    </main>
</template>

<script>
  export default {
    name: 'Home',
    data() {
      return {
        searchTerm: '',
        error: '',
        movies: [],
      };
    },
    methods: {
      async getResults() {
        const MOVIE_URL = "http://localhost:7080";

        const MOVIE_ENDPOINT = `${MOVIE_URL}/movie/?search=${this.searchTerm}`;
        const response = await fetch(MOVIE_ENDPOINT);
        const data = await response.json();

        if (data && data.movies.length) {
          this.movies = data.movies;
          this.error = '';
        } else {
          this.movies = [];
          this.error = 'Not Found';
        }
      },
    },
  };
</script>

<style scoped>
    .movie-card-img {
        max-height: 400px;
        width: auto;
    }

    .movie-card-name {
        min-height: 125px;
    }
</style>
