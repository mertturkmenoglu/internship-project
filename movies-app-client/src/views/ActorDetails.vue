<template>
    <div class="container">
        <ActorDetailCard :id="$route.params.id" class="ml-3 mt-3" />
    </div>
</template>

<script>
  import ActorDetailCard from '../components/ActorDetailCard';

  export default {
    name: 'ActorDetails',
    components: { ActorDetailCard }
  };
</script>

<style scoped>

</style>
