<template>
  <div>
    <div class="card" style="width: 18rem;">
      <img :src="movie.image_path" class="card-img-top movie-card-img" :alt="movie.name">
      <div class="card-body text-wrap">
        <h5 class="card-title">{{movie.name}}</h5>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Movie',
  props: ['movie'],
};
</script>

<style scoped>
  .movie-card-img {
    max-height: 400px;
    width: auto;
  }
</style>
