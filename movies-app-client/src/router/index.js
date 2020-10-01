import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import MovieDetails from '../views/MovieDetails';
import ActorDetails from '../views/ActorDetails';
import DirectorDetails from '../views/DirectorDetails';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/movie/:id',
    name: 'Movie',
    component: MovieDetails
  },
  {
    path: '/actor/:id',
    name: 'Actor',
    component: ActorDetails
  },
  {
    path: '/director/:id',
    name: 'Director',
    component: DirectorDetails
  }
];

const router = new VueRouter({
  routes,
});

export default router;
