<template>
    <div>
        <h1>Cadastrar Nova Disciplina</h1>
        <input type="text" name="nomeDisciplina" id="nomeDisciplina" v-model="disciplina.nomeDisciplina"><br/>
        <input type="number" name="aulasDisciplina" id="aulasDisciplina" v-model="disciplina.aulasDisciplina"><br/>
        <button @click="save()">Salvar</button>
    </div>
</template>

<script setup>
import { reactive } from "@vue/reactivity";
import axios from "axios";
import env from "/env.json"


    const apiURL = env.apiURL

    const disciplina = reactive({
        nomeDisciplina: "",
        aulasDisciplina:""
    })

    const save = () => {
        axios.post(apiURL + "/disciplina/v1/", disciplina)
        .then((response) => {
            if(response.status === 200){
                disciplina.nomeDisciplina = ""
                disciplina.aulasDisciplina = ""
                alert("Dados Cadastrados com sucesso!")                
            }
        }).catch( (error) => {
            alert("Erro: " + error.response.status)
        } )
    }

</script>

<style lang="scss" scoped>

</style>