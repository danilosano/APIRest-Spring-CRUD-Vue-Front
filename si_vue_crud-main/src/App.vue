<script setup>
import Home from '@/views/Home.vue';
</script>

<template>
  <div>
    <h1>Front-End App</h1>
    <ul>
      <li> <router-link to="/">Início</router-link> </li>
      <li> Professores
        <ul>
          <li> <router-link to="/professor/v1/">Listar Professores</router-link> </li>
          <li> <router-link to="/professor/v1/create">Cadastrar</router-link> </li>
        </ul>
      </li>
      <li> Disciplinas
        <ul>
          <li> <router-link to="/disciplina/v1/">Listar Disciplina</router-link> </li>
          <li> <router-link to="/disciplina/v1/create">Cadastrar</router-link> </li>
        </ul>
      </li>
    </ul>
    <router-view />
  </div>
</template>

<style scoped>

</style>
