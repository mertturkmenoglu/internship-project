<template>
    <div class="container mt-2">
        <div class="card mb-3 border-dark">
            <div class="row no-gutters">
                <div class="col-md-3">
                    <img :src="movie.image" class="card-img movie-card-img mt-3 ml-3 mb-3" :alt="movie.name">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <router-link :to="{ name: 'Movie', params: { id: this.id } }" class="text-decoration-none">
                            <h5 class="lead font-weight-bolder">{{movie.name}}</h5>
                        </router-link>
                        <p class="card-text text-muted">{{movie.year}}</p>
                        <p class="card-text">
                            <span class="font-weight-bold">Director:</span>
                            <span class="card-text btn btn-link">
                                <router-link :to="{ name: 'Director', params: { id: movie.directorId } }">
                                    {{directorName}}
                                </router-link>
                            </span>
                        </p>
                        <div>
                            <span class="font-weight-bold">Cast:</span>
                            <ul class="list-group">
                                <li :key="actor.id" v-for="actor in cast"
                                    class="list-group-item-action list-group-item-light text-left mt-2 btn btn-link">
                                    <router-link :to="{ name: 'Actor', params: { id: actor.id } }" class="text-decoration-none">
                                        {{actor.name}}
                                    </router-link>
                                </li>
                            </ul>
                        </div>
                        <div class="mt-3">
                            <span class="font-weight-bold">Genre:</span>
                            <span class="ml-2 badge badge-success">{{movie.genre}}</span>
                        </div>
                        <div class="mt-5">
                            <span class="font-weight-bold">Plot: </span>
                            <span>{{movie.description}}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: 'MovieDetailCard',
    props: [ 'id' ],
    data() {
      return {
        movie: { },
        directorName: '',
        cast: [],
        comments: [],
        showAddComment: false,
        showComments: false,
      }
    },
    methods: {
      async getMovie() {
        const BASE_URL = "http://localhost:7080";
        const response = await fetch(`${BASE_URL}/movie/${this.id}`);
        this.movie = await response.json();
      },

      async getCastInfo() {
        const BASE_URL = "http://localhost:7070";
        const arr = [];

        for (let c of this.movie.cast) {
          const response = await fetch(`${BASE_URL}/actor/${c}`);
          const data = await response.json();
          arr.push(data);
        }

        this.cast = [...arr];
      },

      async getComments() {
        const BASE_URL = "http://localhost:7050";
        const URL = `${BASE_URL}/comment/movie/${this.id}`;

        const response = await fetch(URL);
        const data = await response.json();

        this.comments = data.comments;
      },

      async getDirector() {
        const BASE_URL = "http://localhost:7090";
        const URL = `${BASE_URL}/director/${this.movie.directorId}`;

        const response = await fetch(URL);
        const data = await response.json();

        this.directorName = data.name;
      }
    },
    mounted() {
      this.getMovie()
        .then(() => this.getCastInfo())
        .then(() => this.getComments())
        .then(() => this.getDirector());
    }
  };
</script>

<style scoped>
    .movie-card-img {
        max-width: 250px;
        height: auto;
    }
</style>
