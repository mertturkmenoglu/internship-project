<template>
    <div class="container mt-2">
        <span class="btn btn-outline-primary btn-sm" @click="showAddComment = !showAddComment">Add Comment</span>
        <div v-if="showAddComment" class="mt-4">
            <form @submit.prevent="addComment">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Username</span>
                    </div>
                    <input type="text" id="username" v-model="username" class="form-control" aria-label="Username"
                           placeholder="Enter your username"/>
                </div>
                <div class="input-group mt-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Comment</span>
                    </div>
                    <textarea id="comment" v-model="comment" class="form-control" aria-label="Comment"
                              placeholder="Enter your comment"/>
                </div>
                <div class="input-group mt-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="point">Point</label>
                    </div>
                    <select class="custom-select" id="point" v-model="point">
                        <option selected value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                </div>
                <div>
                    <button type="submit" class="container-fluid btn btn-outline-primary mt-3 mb-5">Send</button>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
  export default {
    name: 'NewComment',
    props: ['id'],
    data() {
      return {
        username: '',
        comment: '',
        point: '',
        showAddComment: false,
      };
    },
    methods: {
      async addComment() {
        const commentObject = {
          movieId: this.id,
          username: this.username,
          content: this.comment,
          point: this.point,
          date: (new Date()).toISOString()
        };

        const URL = "http://localhost:7050/comment/";
        const requestOptions = {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(commentObject)
        }

        await fetch(URL, requestOptions);
      }
    }
  };
</script>

<style scoped>

</style>
