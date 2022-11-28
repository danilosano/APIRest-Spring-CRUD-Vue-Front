<template>
  <div>
    <h1>Profissões Cadastradas</h1>
    <hr />
    <table border="1">
      <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Idade</th>
        <th>Salario</th>
        <th>Disciplina</th>
        <th>Editar</th>
        <th>Excluir?</th>
      </tr>
      <tr v-for="p in professor">
        <td>{{ p.nomeCompleto }}</td>
        <td>{{ p.email }}</td>
        <td>{{ p.idade }}</td>
        <td>{{ p.salario }}</td>
        <td>{{ p.disciplina.nomeDisciplina }}</td>
        <td>
          <router-link :to="{ name: 'pro-edit', params: { id: p.id } }"
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

const professor = ref([]);

const findAll = () => {
  axios
    .get(apiURL + "/professor/v1/")
    .then((response) => {
      professor.value = response.data;
    })
    .catch((error) => {
      alert("Erro: " + error.response.status);
    });
};

const destroy = (id) => {
  if (confirm("Deseja excluir o professor selecionado?")) {
    axios
      .delete(apiURL + "/professor/v1/" + id)
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
  console.log("data: " + professor.value);
});
</script>

<style lang="scss" scoped></style>
