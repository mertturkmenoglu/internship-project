<template>
    <div class="container mt-2">
        <div class="card mb-3 border-dark">
            <div class="row no-gutters">
                <div class="col-md-3">
                    <img :src="actor.image" class="card-img movie-card-img  mt-3 ml-3 mb-3 mr-3" :alt="actor.name">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <router-link :to="{ name: 'Actor', params: { id: this.id } }" class="text-decoration-none">
                            <h5 class="lead font-weight-bolder">{{actor.name}}</h5>
                        </router-link>
                        <p class="card-text text-muted">Birth: {{actor.bdate}}</p>
                        <div>
                            <span class="font-weight-bold">Movies</span>
                            <ul class="list-group">
                                <li :key="movie.id" v-for="movie in actor.movies"
                                    class="list-group-item-action list-group-item-light text-left mt-2 btn btn-link">
                                    <router-link :to="{ name: 'Movie', params: { id: movie.id } }">
                                        {{movie.name}}
                                    </router-link>
                                </li>
                            </ul>
                        </div>
                        <div class="mt-5">
                            <span class="font-weight-bold">Details: </span>
                            <span>{{actor.description}}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>


  export default {
    name: 'ActorDetailCard',
    props: ['id'],
    data() {
      return {
        actor: {
          id: '',
          name: '',
          image: '',
          bdate: '',
          movies: [],
          description: '',
        },
      };
    },
    methods: {
      async getActor() {
        const BASE_URL = 'http://localhost:7070/actor';
        const res = await fetch(`${BASE_URL}/${this.id}`);
        this.actor = await res.json();
      },

      async getMovieInfo() {
        const BASE_URL = 'http://localhost:7080';
        const arr = [];

        for (let movieId of this.actor.movies) {
          const URL = `${BASE_URL}/movie/${movieId}`;
          const response = await fetch(URL);
          const data = await response.json();
          arr.push(data);
        }

        this.actor.movies = [...arr];
      }
    },
    mounted() {
      this.getActor().then(() => this.getMovieInfo());
    }
  };
</script>

<style scoped>
    .movie-card-img {
        max-width: 250px;
        height: auto;
    }
</style>
