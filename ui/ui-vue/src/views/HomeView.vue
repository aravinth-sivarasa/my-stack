<template>
    <div class="body-dashboard" :class="bodyStyle">
        <nav class="sidebar" :class="navStyle">
            <header>
                <div class="image-text">
                    <span class="image">
                        <img src="../assets/telenor-logo.png" alt="">
                    </span>
                    <div class="text header-text">
                        <span class="name">Demo</span>
                        <span class="profession">Portal</span>
                    </div>
                </div>
                <i class="bx bx-chevron-right toggle" @click="close()"></i>
            </header>
            <div class="menu-bar">
                <div class="menu">
                    <li class="search-box">
                        <i class="bx bx-search icon"></i>
                        <input type="text" placeholder="Search...">
                    </li>
                    <ul class="menu-links">
                        <li class="nav-link">
                            <a href="/vue/home/dashboard">
                                <i class="bx bx-home-alt icon"></i>
                                <span class="text nav-text">Dashboard</span>
                            </a>
                        </li>
                        <li class="nav-link">
                            <a href="/vue/home/invoices">
                                <i class="bx bx-wallet icon"></i>
                                <span class="text nav-text">Invoices</span>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="bottom-content">
                    <li class="">
                        <a href="/logout">
                            <i class="bx bx-log-out icon"></i>
                            <span class="text nav-text">Logout</span>
                        </a>
                    </li>

                    <li class="mode">
                        <div class="moon-sun">
                            <i class="bx bx-moon icon moon"></i>
                            <i class="bx bx-sun icon sun"></i>
                        </div>
                        <span class="mode-text text">{{lblMode}}</span>
                        <div class="toggle-switch">
                            <span class="switch" @click="toggle()">

                            </span>
                        </div>
                    </li>
                </div>
            </div>
        </nav>
        <section class="home">
            <div class="text">Home</div>
            <router-view/>
        </section>
    </div>
</template>
<script lang="ts">

import { defineComponent } from "vue";
export default defineComponent({

    data(){
        return {
            bodyStyle: "dark",
            darkMode: true,
            navStyle: "",
            closeNav: false,
            lblMode: "Light Mode"
        }
    },
    methods:{
        toggle(){
            this.darkMode = !this.darkMode
            if(this.darkMode){
                this.bodyStyle = "dark"
                this.lblMode = "Light Mode"
            }else{
                this.bodyStyle = ""
                this.lblMode = "Dark Mode"
            }
            // this.$emit("update:darkMode",!this.darkMode)
        },
        close(){
            this.closeNav = !this.closeNav
            if(this.closeNav){
                this.navStyle = "close"
            }else{
                this.navStyle = ""
            }
          
        }
    }
});
</script>
<style>
:root {
    --body-color: #e4e9f7;
    --sidebar-color: #fff;
    --primary-color: #00c8ff;
    --primary-color-light: #f6f5ff;
    --toggle-color: #ddd;
    --text-color: #707070;

    --tran-02: all 0.2s ease;
    --tran-03: all 0.3s ease;
    --tran-04: all 0.4s ease;
    --tran-05: all 0.5s ease;

}

.body-dashboard.dark {
    --body-color: #18191a;
    --sidebar-color: #242526;
    --primary-color: #00c8ff;
    --primary-color-light: #3a3b3c;
    --toggle-color: #fff;
    --text-color: #ccc;
}

/* body { */
.body-dashboard{
    height: 100vh;
    background: var(--body-color);
    transition: var(--tran-05);
}

/* ==== Reusable CSS ==== */

.sidebar .text {
    font-size: 16px;
    font-weight: 500;
    color: var(--text-color);
    transition: var(--tran-04);
    white-space: nowrap;
    opacity: 1;
}
.sidebar.close .text{
    opacity: 0;
}


.sidebar .image {
    min-width: 60px;
    display: flex;
    align-items: center;
    justify-content: center;
}

/* ==== Sidebar ==== */
.sidebar {
    position: fixed;
    top: 0;
    left: 0;
    height: 100%;
    width: 250px;
    padding: 10px 14px;
    background: var(--sidebar-color);
    transition: var(--tran-05);
    z-index: 100;
}

.sidebar.close {
    width: 88px;
}
.sidebar .image-text img {
    width: 40px;
    border-radius: 6px;
}

.sidebar header .image-text {
    display: flex;
    align-items: center;
}

header .image-text .header-text {
    display: flex;
    flex-direction: column;
}

.header-text .name {
    font-weight: 600;
}

.header-text .profession {
    margin-top: -2px;
}

.sidebar li {
    height: 50px;
    margin-top: 10px;
    list-style: none;
    display: flex;
    align-items: center;
}

.sidebar li .icon {
    display: flex;
    align-items: center;
    justify-content: center;
    min-width: 60px;
    font-size: 20px;
}

.sidebar li .icon,
.sidebar li .text {
    color: var(--text-color);
    transition: var(--tran-02);
}

.sidebar header {
    position: relative;
}

.sidebar header .toggle {
    position: absolute;
    top: 50%;
    right: -25px;
    transform: translateY(-50%) rotate(180deg);
    height: 25px;
    width: 25px;
    background: var(--primary-color);
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 50%;
    color: var(--sidebar-color);
    font-size: 22px;
    transition: var(--tran-03);
}

.sidebar.close header .toggle {
    transform: translateY(-50%);
}

.body-dashboard.dark .sidebar header .toggle {
    color: var(--text-color);
}

.sidebar .menu {
    margin-top: 35px;
}

.sidebar .search-box {
    background: var(--primary-color-light);
    border-radius: 6px;
    transition: var(--tran-05);
}

.search-box input {
    height: 100%;
    width: 100%;
    outline: none;
    border: none;
    border-radius: 6px;
    font-size: 16px;
    background: var(--primary-color-light);
    transition: var(--tran-05);
    color: var(--text-color);
}

.sidebar li a {
    height: 100%;
    width: 100%;
    display: flex;
    align-items: center;
    text-decoration: none;
    border-radius: 6px;
    transition: var(--tran-04);
}

.sidebar li a:hover {
    background: var(--primary-color);
}

.sidebar li a:hover .icon,
.sidebar li a:hover .text {
    color: var(--sidebar-color)
}

.body-dashboard.dark .sidebar li a:hover .icon,
.body-dashboard.dark .sidebar li a:hover .text {
    color: var(--text-color)
}

.sidebar .menu-bar{
    height: calc(100% - 50px);
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}
.menu-bar .mode {
    position: relative;
    border-radius: 6px;
    background: var(--primary-color-light);
}

.menu-bar .mode .moon-sun{
    height: 50px;
    width: 60px;
    display: flex;
    align-items: center;
}

.menu-bar .mode i {
    position: absolute;
    transition: var(--tran-03);
}
.menu-bar .mode i.sun {
    opacity: 0;
}

.body-dashboard.dark .menu-bar .mode i.sun{
    opacity: 1;
}

.body-dashboard.dark .menu-bar .mode i.moon{
    opacity: 0;
}

.menu-bar .mode .toggle-switch{
    position: absolute;
    right: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100%;
    min-width: 60px;
    cursor: pointer;
    border-radius: 6px;
    background: var(--primary-color-light);
}

.toggle-switch .switch {
    position: relative;
    height: 22px;
    width: 44px;
    border-radius: 25px;
    background: var(--toggle-color);
}

.switch::before {
    content: '';
    position: absolute;
    height: 15px;
    width: 15px;
    border-radius: 50%;
    top: 50%;
    left: 5px;
    transform: translateY(-50%);
    background: var(--sidebar-color);
    transition: var(--tran-03);
}

.body-dashboard.dark .switch::before{
    left: 24px;
}
.home {
    position: relative;
    height: 100vh;
    left: 250px;
    width: calc(100% - 250px);
    background: var(--body-color);
    transition: var(--tran-05);
}

.home .text {
    font-size: 30px;
    font-weight: 500;
    color: var(--text-color);
    padding: 8px 40px;
}

.sidebar.close ~ .home{
    left: 88px;
    width: calc(100% - 88px);

}
.copyright.text {
    color: var(--text-color);
}
</style>