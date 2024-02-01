<template>
<div>
  <router-view/>

  <footer>
        <p class="copyright text">© {{ new Date().getFullYear() }} Telenor Group</p>
  </footer>
</div>
</template>
<style>
@import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap");
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: "Poppins", sans-serif;
}

footer {
    position: relative;
    width: 100%;
    background-color: transparent;
}

p.copyright {
    position: absolute;
    width: 100%;
    color: #fff;
    line-height: 40px;
    font-size: 0.7em;
    text-align: center;
    bottom:0;
}
</style>