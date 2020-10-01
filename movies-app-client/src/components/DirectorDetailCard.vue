<template>
    <div class="container mt-2">
        <div class="card mb-3 border-dark">
            <div class="row no-gutters">
                <div class="col-md-3">
                    <img :src="director.image" class="card-img movie-card-img  mt-3 ml-3 mb-3 mr-3" :alt="director.name">
                </div>
                <div class="col-md-8 ml-3">
                    <div class="card-body">
                        <router-link :to="{ name: 'Director', params: { id: this.id } }" class="text-decoration-none">
                            <h5 class="lead font-weight-bolder">{{director.name}}</h5>
                        </router-link>
                        <p class="card-text text-muted">Birth: {{director.bdate}}</p>
                        <div>
                            <span class="font-weight-bold">Movies:</span>
                            <ul class="list-group">
                                <li :key="movie.id" v-for="movie in director.movies"
                                    class="list-group-item-action list-group-item-light text-left mt-2 btn btn-link">
                                    <router-link :to="{ name: 'Movie', params: { id: movie.id } }" class="text-decoration-none">
                                        {{movie.name}}
                                    </router-link>
                                </li>
                            </ul>
                        </div>
                        <div class="mt-5">
                            <span class="font-weight-bold">Details: </span>
                            <span>{{director.description}}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: 'DirectorDetailCard',
    props: ['id'],
    data() {
      return {
        director: {
          name: '',
          image_path: '',
          birth_year: '',
          movies: [],
          description: ''
        },
      }
    },
    methods: {
      async getDirector() {
        const BASE_URL = "http://localhost:7090";
        const response = await fetch(`${BASE_URL}/director/${this.id}`);
        this.director = await response.json();
      },

      async getMovieInfo() {
        const BASE_URL = 'http://localhost:7080';
        const arr = [];

        for (let movieId of this.director.movies) {
          const URL = `${BASE_URL}/movie/${movieId}`;
          const response = await fetch(URL);
          const data = await response.json();
          arr.push(data);
        }

        this.director.movies = [...arr];
      }
    },
    mounted() {
      this.getDirector().then(() => this.getMovieInfo());
    }
  };
</script>

<style scoped>
    .movie-card-img {
        max-width: 250px;
        height: auto;
    }
</style>
