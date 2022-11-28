import { createWebHistory, createRouter } from "vue-router"

const routes = [
    { path : '/', name: "home", 
        component : () => import("@/views/Home.vue") 
    },
    { path : '/professor/v1', name: "pro",
      component : () => import("@/views/professor/Index.vue") 
    },
    { path : '/professor/v1/create', name : "pro-create", 
      component : () => import("@/views/professor/Create.vue") 
    },
    { path: '/professor/v1/edit:id', name: "pro-edit",
      component: () => import("@/views/professor/Edit.vue")
    },
    { path : '/disciplina/v1', name: "disc",
      component : () => import("@/views/disciplina/Index.vue") 
    },
    { path : '/disciplina/v1/create', name : "disc-create", 
      component : () => import("@/views/disciplina/Create.vue") 
    },
    {path: '/disciplina/v1/edit:id', name: "disc-edit",
      component: () => import("@/views/disciplina/Edit.vue")
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;