<template>
<div>
    <div class="body-login">
        <div class="wrapper">
            <form action="/vue/login" method="POST">
                <h1>Logg inn</h1>
                <div class="input-box">
                    <input type="text" name="username" placeholder="Brukernavn" required  />
                    <!-- <box-icon name="user" type="solid" class="icon-style"></box-icon> -->
                    <i class="bx bxs-user"></i>
                </div>
                <div class="input-box">
                    <input type="password" name="password" placeholder="Passord" required />
                    <i class="bx bxs-lock-alt"></i>
                </div>
                <div class="remember-forgot">
                    <label><input type="checkbox">Husk meg</label>
                    <a href="#">Glemt passord?</a>
                </div>
                <button class="btn" type="submit">Logg inn</button>
                <div class="register-link">
                    <p>
                        Har ikke en konto? <a href="#">Registrer deg</a>
                    </p>
                </div>
            </form>
        </div>
    </div>

</div>
    
  
</template>
<script lang="ts">
import { defineComponent } from "vue";
import { toast } from "vue3-toastify";
import { useRoute } from 'vue-router'
import "vue3-toastify/dist/index.css";


export default defineComponent({

    setup(){
        const route = useRoute();
        if(route.query.error === null){
            toast("Ugyldig brukernavn eller passord", {
                "theme": "colored",
                "type": "error",
                icon: false,
                hideProgressBar: true
            })
        }
       
    }

});
</script>
<style>
.body-login {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background: url("@/assets/telenor-cover.png") no-repeat;
    background-size: cover;
    background-position: center;
}

.wrapper{
    width: 420px;
    background: rgb(0, 200, 255, 0.3);
    /* background: transparent; */
    color: #fff;
    border-radius: 10px;
    padding: 30px 40px;
}
.wrapper h1 {
    font-size: 36px;
    text-align: center;
}
.wrapper .input-box{
    position: relative;
    width: 100%;
    height: 50px;
    margin: 30px 0;
}

.input-box input{
    width: 100%;
    height: 100%;
    background: transparent;
    border: none;
    outline: none;
    border: 2px solid rgba(255, 255, 255, .2);
    border-radius: 40px;
    font-size: 16px;
    color: #fff;
    padding: 20px 45px 20px 20px;

}

.input-box input::placeholder{
    color: #fff;
}
.icon-style{
    position: absolute;
    right: 20px;
    top: 50%;
    transform: translateY(-50%);
    font-size: 20px;
    color: #fff;
}

.input-box i{
    position: absolute;
    right: 20px;
    top: 50%;
    transform: translateY(-50%);
    font-size: 20px;
    color: #fff;
}
.wrapper .remember-forgot{
    display: flex;
    justify-content: space-between;
    font-size: 14.5px;
    margin: -15px 0 15px;
}

.remember-forgot label input{
    accent-color: #fff;
    margin-right: 3px;
}

.remember-forgot a {
    color:#fff;
    text-decoration: none;
}
.remember-forgot a:hover{
    text-decoration: underline;
}
.wrapper .btn{
    width: 100%;
    height: 45px;
    background: #fff;
    border: none;
    outline: none;
    border-radius: 40px;
    box-shadow: 0 0 10px rgba(0,0,0,.1);
    cursor: pointer;
    font-size: #333;
    font-weight: 600;
    color: #00c8ff;
}
.wrapper .register-link{
    font-size: 14.5px;
    text-align: center;
    margin: 20px 0 15px;
}

.register-link p a {
    color: #fff;
    text-decoration: none;
    font-weight: 600;
}

.register-link p a:hover{
    text-decoration: underline;
}
</style>