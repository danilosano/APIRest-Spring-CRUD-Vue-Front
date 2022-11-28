<template>
  <div>
    <h1>Profissões Cadastradas</h1>
    <hr />
    <table border="1">
      <tr>
        <th>Nome</th>
        <th>Editar</th>
        <th>Excluir?</th>
      </tr>
      <tr v-for="p in disciplina">
        <td>{{ p.nomeDisciplina }}</td>
        <td>{{ p.aulasDisciplina }}</td>
        <td>
          <router-link :to="{ name: 'disc-edit', params: { id: p.id } }"
            >Editar</router-link
          >
        </td>
        <td><button @click="destroy(p.id)">Excluir</button></td>
      </tr>
    </table>
  </div>
</template>

<script setup>
import env from "/env.json";
import { onMounted, ref } from "@vue/runtime-core";
import axios from "axios";

const apiURL = env.apiURL;

const disciplina = ref([]);

const findAll = () => {
  axios
    .get(apiURL + "/disciplina/v1/")
    .then((response) => {
      disciplina.value = response.data;
    })
    .catch((error) => {
      alert("Erro: " + error.response.status);
    });
};

const destroy = (id) => {
  if (confirm("Deseja excluir a disciplina selecionada?")) {
    axios
      .delete(apiURL + "/disciplina/v1/" + id)
      .then((response) => {
        if (response.status === 200 && response.data == "") {
          alert("Dados Excluídos com sucesso!");
          findAll();
        }
      })
      .catch((error) => {
        alert("Erro: " + error.response.status);
      });
  }
};

onMounted(() => {
  findAll();
  console.log("data: " + disciplina.value);
});
</script>

<style lang="scss" scoped></style>
