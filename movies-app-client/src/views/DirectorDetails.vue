<template>
    <div class="container">
        <DirectorDetailCard :id="$route.params.id" class="ml-3 mt-3"/>
    </div>
</template>

<script>
  import DirectorDetailCard from '../components/DirectorDetailCard';

  export default {
    name: 'DirectorDetails',
    components: { DirectorDetailCard },
  };
</script>

<style scoped>

</style>
