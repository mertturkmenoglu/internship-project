<template>
    <div class="container">
        <MovieDetailCard :id="$route.params.id" class="mt-3" />
        <NewComment :id="$route.params.id" class="mt-3" />
        <MovieComments :id="$route.params.id" class="my-3" />
    </div>
</template>

<script>
  import MovieDetailCard from '../components/MovieDetailCard';
  import MovieComments from '../components/MovieComments';
  import NewComment from '../components/NewComment';

  export default {
    name: 'MovieDetails',
    components: { NewComment, MovieComments, MovieDetailCard },
  };
</script>

<style scoped>

</style>
