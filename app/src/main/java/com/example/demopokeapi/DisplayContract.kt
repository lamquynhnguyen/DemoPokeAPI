package com.example.demopokeapi

interface DisplayContract {
    interface View {
        fun display()
    }

    interface Present {
        fun handleDisplay()
    }
}
