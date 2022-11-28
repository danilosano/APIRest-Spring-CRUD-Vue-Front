<template>
    <div>
        <h1>Editar Disciplina</h1>
        <input type="text" name="nomeDisciplina" id="nomeDisciplina" v-model="disciplina.nomeDisciplina"><br/>
        <input type="number" name="aulasDisciplina" id="aulasDisciplina" v-model="disciplina.aulasDisciplina"><br/>
        <button @click="update">Salvar</button>
    </div>
</template>

<script setup>
import { onMounted, ref } from "vue"
import env from "/env.json"
import { useRoute } from "vue-router";
import axios from "axios";

const apiURL = env.apiURL

const route = useRoute()

const disciplina = ref({ id: null, nomeDisciplina : "", aulasDisciplina: "" })

const load = () => {
    let id = route.params.id
    axios.get(apiURL + "/disciplina/v1/" + id)
    .then((response) => {
        disciplina.value.id = response.data.id;
        disciplina.value.nomeDisciplina = response.data.nomeDisciplina;
        disciplina.value.aulasDisciplina = response.data.aulasDisciplina;
    }).catch((error) => {
        alert("Erro: " + error.response.status)
    })
}

const update = () => {
    axios.put(apiURL + "/disciplina/v1/", disciplina.value)
    .then((response) => {
        if(response.data != ""){
            alert("Dados atualizados com sucesso!")
            load()
        }
    }).catch((error) => {
        alert("Erro: " + error.response.status)
    })
}

onMounted(() => {
    load();
})

</script>

<style lang="scss" scoped>

</style>