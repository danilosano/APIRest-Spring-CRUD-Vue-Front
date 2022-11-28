<template>
    <div>
        <h1>Editar Professor</h1>
        <input type="text" name="nomeCompleto" id="nomeCompleto" placeholder="Nome Completo" v-model="professor.nomeCompleto"><br/>
        <input type="text" name="email" id="email" placeholder="Email" v-model="professor.email"><br/>
        <input type="number" name="idade" id="idade" placeholder="Idade" v-model="professor.idade"><br/>
        <input type="number" name="salario" id="salario" placeholder="Salário" v-model="professor.salario"><br/>
        <select name="disciplina" id="disciplina" v-model="professor.disciplina">
            <option v-bind:value="disciplina" v-for="disciplina in disciplinas">
                {{disciplina.nomeDisciplina}}
            </option>
        </select>
        <button @click="update">Salvar</button>
    </div>
</template>

<script setup>
import { onMounted, ref } from "@vue/runtime-core";
import env from "/env.json"
import { useRoute } from "vue-router";
import axios from "axios";

const apiURL = env.apiURL;

const route = useRoute();

const professor = ref({ id: null, nomeCompleto : "", email: "" , idade: "" , salario: "" , disciplina: "" });

const disciplinas = ref([]);

const load = () => {
    let id = route.params.id
    axios.get(apiURL + "/professor/v1/" + id)
    .then((response) => {
        professor.value.id = response.data.id;
        professor.value.nomeCompleto = response.data.nomeCompleto;
        professor.value.email = response.data.email;
        professor.value.idade = response.data.idade;
        professor.value.salario = response.data.salario;
        professor.value.disciplina = response.data.disciplina;
    }).catch((error) => {
        alert("Erro: " + error.response.status)
    })
}

const update = () => {
    axios.put(apiURL + "/professor/v1/", professor.value)
    .then((response) => {
        if(response.data != ""){
            alert("Dados atualizados com sucesso!")
            load()
        }
    }).catch((error) => {
        alert("Erro: " + error.response.status)
    })
}

const findAllDisciplinas = () => {
        axios
            .get(apiURL + "/disciplina/v1/")
            .then((response) => {
            disciplinas.value = response.data;
            })
            .catch((error) => {
            alert("Erro: " + error.response.status);
            });
    };

onMounted(() => {
    findAllDisciplinas();
    load();
})

</script>

<style lang="scss" scoped>

</style>