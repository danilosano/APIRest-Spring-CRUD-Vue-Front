<template>
    <div>
        <h1>Cadastrar Novo Professor</h1>
        <input type="text" name="nomeCompleto" id="nomeCompleto" placeholder="Nome Completo" v-model="professor.nomeCompleto"><br/>
        <input type="text" name="email" id="email" placeholder="Email" v-model="professor.email"><br/>
        <input type="number" name="idade" id="idade" placeholder="Idade" v-model="professor.idade"><br/>
        <input type="number" name="salario" id="salario" placeholder="Salário" v-model="professor.salario"><br/>
        <select name="disciplina" id="disciplina" v-model="professor.disciplina">
            <option v-bind:value="disciplina" v-for="disciplina in disciplinas">
                {{disciplina.nomeDisciplina}}
            </option>
        </select>
        <button @click="save()">Salvar</button>
    </div>
</template>

<script setup>
import { reactive } from "@vue/reactivity";
import axios from "axios";
import env from "/env.json";
//ve se ta com essas importações
import { onMounted, ref } from "@vue/runtime-core";

    const apiURL = env.apiURL;

    const professor = reactive({
        nomeCompleto: "",
        email:"",
        idade:"",
        salario:"",
        disciplina: ""
    });
//variavel que vai ficar a classe filha
    const disciplinas = ref([]);

    const save = () => {
        console.log(professor.disciplina);
        axios.post(apiURL + "/professor/v1/", professor)
        .then((response) => {
            if(response.status === 200){
                professor.nomeCompleto = ""
                professor.email = ""
                professor.idade = ""
                professor.salario = ""
                alert("Dados Cadastrados com sucesso!")                
            }
        }).catch( (error) => {
            alert("Erro: " + error.response.status)
        } )
    }
//Aqui eu dei o findAll igual do listar pra pegar todas as disciplinas(classe filha)
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
//Quando ele carregar essa pagina ele faz isso, entao ele carrega a pagina e ja busca todas as diciplinas
    onMounted(() => {
        findAllDisciplinas();
    });

</script>

<style lang="scss" scoped>

</style>