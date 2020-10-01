<template>
    <div class="container mt-2">
        <span class="btn btn-outline-primary btn-sm" @click="showComments = !showComments">
                <span v-if="!showComments">Show</span>
                <span v-if="showComments">Hide</span> Comments
        </span>
        <div v-if="showComments">
            <div class="container-fluid">
                <div v-if="!comments.length" class="alert alert-danger col mt-3" role="alert">
                    No Comments
                </div>
            </div>
            <div class="container" style="padding: 0;">
                <div :key="comment.id" v-for="comment in comments">
                    <div class="card border-dark text-white mt-3">
                        <div class="card-body">
                            <div>
                                <span class="card-title text-dark font-weight-bold">{{comment.username}}</span>
                                <span class="text-danger font-weight-bolder float-right">({{comment.point}}/10)</span>
                            </div>
                            <div>
                                <span class="card-text text-dark">{{comment.content}}</span>
                                <span class="card-text text-muted float-right">{{new Date(comment.date).toLocaleDateString()}}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    name: 'MovieComments',
    props: ['id'],
    data() {
      return {
        comments: [],
        showComments: false,
      }
    },
    methods: {
      async getComments() {
        const BASE_URL = "http://localhost:7050";
        const URL = `${BASE_URL}/comment/movie/${this.id}`;

        const response = await fetch(URL);
        const data = await response.json();

        this.comments = data.comments;
      },
    },
    mounted() {
        this.getComments();
    }
  };
</script>

<style scoped>

</style>
