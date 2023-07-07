<template>
    <div class="alert-container">
      <el-alert
        v-for="(item, index) in err_mess"
        :key="index"
        :title="item.message"
        :type="item.type"
        :show-icon="true"
        :center="center"
        :class="['alerted']"
      ></el-alert>
    </div>
    <section class="login-section">
      <div class="color"></div>
      <div class="color"></div>
      <div class="color"></div>
      <div class="box">
        <div class="circle"></div>
        <div class="circle"></div>
        <div class="circle"></div>
        <div class="square" style="--i: 0"></div>
        <div class="square" style="--i: 1"></div>
        <div class="square" style="--i: 2"></div>
        <div class="square" style="--i: 3"></div>
        <div class="square" style="--i: 4"></div>
        <div class="container">
          <div class="form">
            <h2>LOGIN</h2>
            <form action="#.php" method="post">
              <div class="inputbox">
                <input type="text" placeholder="Username" />
              </div>
              <div class="inputbox">
                <input type="password" placeholder="Password" />
              </div>
              <div class="inputbox">
                <input type="submit" value="Login" />
              </div>
              <p class="forget">
                Don't have an accent ?
                <router-link :to="{ path: '/register' }">Register</router-link>
              </p>
            </form>
          </div>
        </div>
      </div>
    </section>
</template>

<script lang="js">
import {reactive, toRefs} from "vue";
import { mapMutations } from 'vuex';

export default {
  name: "Login",
  data() {
    return {
      err_msg: "",
      err_type: "",
      display_err: false,
      err_mess: []
    }
  },
  created() {
    const style = document.createElement('style');
    style.innerText = 'body { overflow: hidden; }';
    style.className = 'overflow-hidden-style'
    document.head.appendChild(style);
  },
  beforeUnmount() {
    const style = document.head.querySelector('.overflow-hidden-style');
    document.head.removeChild(style);
  },
  mounted() {
    localStorage.removeItem("token");

    //阻止文本选中
    let formh2 = document.querySelector(".form h2");
    formh2.addEventListener("selectstart", function (e) {
        e.preventDefault();
    });

    let username = document.querySelector("[type='text']");
    let password = document.querySelector("[type='password']");
    let submit = document.querySelector("[type='submit']");

    let router_t = this.$router
    let showAlert = this.showAlert
    let _updateData = this.updateData
    submit.addEventListener("click", function (event) {
        let usernameValue = username.value;
        let passwordValue = password.value;
        event.preventDefault();

        if (usernameValue.trim() === '') {
            username.style.borderColor = 'red';
            username.style.color = 'red';
            username.style.borderWidth = '2px';
            username.addEventListener('focus', function () {
                this.style.borderColor = '';
                this.style.color = '';
                this.style.borderWidth = '1px';
            }, { once: true });
            showAlert('Username cannot be empty', 'error');
        }

        else if (passwordValue.trim() === '') {
            password.style.borderColor = 'red';
            password.style.color = 'red';
            password.style.borderWidth = '2px';
            password.addEventListener('focus', function () {
                this.style.borderColor = '';
                this.style.color = '';
                this.style.borderWidth = '1px';
            }, { once: true });
            showAlert("Password cannot be empty", 'error');
        }
        else {

            let usernameRegex = /^[a-zA-Z0-9]{1,20}$/;
            let passwordRegex = /^.{1,20}$/;

            if (!usernameRegex.test(usernameValue)) {
                username.style.borderColor = 'red';
                username.style.color = 'red';
                username.style.borderWidth = '2px';
                username.addEventListener('focus', function () {
                    this.style.borderColor = '';
                    this.style.color = '';
                    this.style.borderWidth = '1px';
                }, { once: true });
                showAlert('Invalid username: Username can only consist of letters, digits and underscores, and must be between 1 and 20 characters long', 'error');
            }

            else if (!passwordRegex.test(passwordValue)) {
                password.style.borderColor = 'red';
                password.style.color = 'red';
                password.style.borderWidth = '2px';
                password.addEventListener('focus', function () {
                    this.style.borderColor = '';
                    this.style.color = '';
                    this.style.borderWidth = '1px';
                }, { once: true });
                showAlert("Password must be between 8 and 20 characters long", 'error');
            }
            else {
              //http://139.196.197.42:1520/
                fetch('http://139.196.197.42:8085/login', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        'username': usernameValue,
                        'password': passwordValue
                    })
                })
                    .then(response => response.json())
                    .then(data => {
                        if (data.code === 1) {
                            showAlert(data.msg, 'success');
                            _updateData(data.data.permission);
                            localStorage.setItem('token', data.data.token);
                            sessionStorage.setItem('toefl', data.data.toefl);
                            sessionStorage.setItem('ielts', data.data.ielts);
                            sessionStorage.setItem('gre', data.data.gre);
                            if (data.data.permission > 0) {
                                setTimeout(() => {
                                    router_t.push({path: "/main"})
                                }, 400);
                            }
                            else {
                                setTimeout(() => {
                                    router_t.push({path: "/main"})
                                }, 400);
                            }
                        }
                        else
                            showAlert(data.msg, 'error');
                    }).catch(error => console.log(error));
            }
        }
    });
  },
  methods: {

    ...mapMutations(['setData']),
    updateData: function(param) {
      this.setData(param);
    },
    showAlert: function(message, type, duration = 2000) {
      this.err_mess.push({
        "message": message,
        "type": type
      })
      // 设置自动关闭计时器
      if (duration > 0) {
          setTimeout(() => {
              this.err_mess.shift()
          }, duration);
      }
    },
    createAlert: function(message, type) {
      const alert = document.createElement('el-alert');
      alert.setAttribute('title', message)
      alert.setAttribute('type', type);
      alert.setAttribute('center', true);
      alert.setAttribute('show-icon', true);
      alert.classList.add("alerted");
      return alert;
    }
  }
}
</script>

<style scoped lang="css">
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}

.alerted {
  left: 50%;
  transform: translateX(-50%);
  max-width: 350px;
  box-sizing: border-box;
  /* border: 1px solid; */
  padding: 10px;
  z-index: 50;
  border-radius: 10px;
  opacity: 0.8;
  margin-bottom: 20px;
}

.alert-container {
  position: absolute;
  top: 10%;
  left: 50%;
  transform: translateX(-50%);
  /* max-width: 350px; */
  z-index: 50;
  height: 50px;
  width: 600px;
}

.login-section {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background: linear-gradient(to right bottom, #ecf9ee, #bae8c1);
}

.login-section .color {
  position: absolute;
  filter: blur(150px);
}

.login-section .color:nth-child(1) {
  top: -500px;
  width: 900px;
  height: 900px;
  background: #a1e7ae;
}

.login-section .color:nth-child(2) {
  bottom: -150px;
  left: 100px;
  width: 500px;
  height: 500px;
  background: #87f49b;
}

.login-section .color:nth-child(3) {
  bottom: 50px;
  right: 100px;
  width: 400px;
  height: 400px;
  background: #81ff98;
}

.box {
  position: relative;
}

@keyframes animate {
  0%,
  100% {
    transform: translateY(-40px);
  }

  50% {
    transform: translateY(40px);
  }
}

.box .circle {
  position: absolute;
  backdrop-filter: blur(5px);
  border-radius: 50%;
  opacity: 0.8;
}

.box .circle:nth-child(1) {
  top: -30px;
  right: -270px;
  width: 350px;
  height: 350px;
  transform: rotate(-45deg);
  filter: blur(2px);
  box-shadow: -15px 5px 45px rgba(0, 0, 0, 0.05);
  border-right: 1px solid rgba(255, 255, 255, 0.5);
  border-left: 3px solid rgba(255, 255, 255, 0.5);
}

.box .circle:nth-child(2) {
  top: -250px;
  left: -170px;
  width: 280px;
  height: 280px;
  box-shadow: inset 5px 5px 5px rgba(255, 255, 255, 0.1),
    inset -5px -5px 15px rgba(255, 255, 255, 0.1);
}

.box .circle:nth-child(3) {
  bottom: -340px;
  left: 100px;
  width: 230px;
  height: 230px;
  box-shadow: inset 5px 5px 5px rgba(255, 255, 255, 0.1),
    inset -5px -5px 15px rgba(255, 255, 255, 0.1);
}

.box .square {
  position: absolute;
  backdrop-filter: blur(5px);
  box-shadow: 0 25px 45px rgba(0, 0, 0, 0.1);
  border: 1px solid rgba(255, 255, 255, 0.5);
  border-right: 1px solid rgba(255, 255, 255, 0.2);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  border-radius: 10px;
  animation: animate 10s linear infinite;
  animation-delay: calc(-1s * var(--i));
}

.box .square:nth-child(4) {
  top: -50px;
  right: -60px;
  width: 100px;
  height: 100px;
}

.box .square:nth-child(5) {
  top: 150px;
  left: -100px;
  width: 120px;
  height: 120px;
  z-index: 2;
}

.box .square:nth-child(6) {
  bottom: 50px;
  right: -60px;
  width: 80px;
  height: 80px;
  z-index: 2;
}

.box .square:nth-child(7) {
  bottom: -40px;
  left: 100px;
  width: 50px;
  height: 50px;
}

.box .square:nth-child(8) {
  top: -80px;
  left: 140px;
  width: 60px;
  height: 60px;
}

.container {
  position: relative;
  width: 400px;
  min-height: 400px;
  background: rgba(255, 255, 255, 0.1);
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  backdrop-filter: blur(5px);
  box-shadow: 0 25px 45px rgba(0, 0, 0, 0.1);
  border: 1px solid rgba(255, 255, 255, 0.5);
  border-right: 1px solid rgba(255, 255, 255, 0.2);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
}

.form {
  position: relative;
  height: 100%;
  width: 100%;
  padding: 40px;
}

.form h2 {
  position: relative;
  color: white;
  font-size: 24px;
  font-weight: 600;
  letter-spacing: 1px;
  margin-bottom: 40px;
  cursor: default;
}

.form h2::before {
  content: "";
  position: absolute;
  left: 0;
  bottom: -10px;
  width: 146px;
  height: 4px;
  border-radius: 5px;
  background: white;
}

.form .inputbox {
  width: 100%;
  margin-top: 20px;
}

.form .inputbox input {
  width: 100%;
  background: rgba(255, 255, 255, 0.2);
  outline: none;
  border: none;
  padding: 10px 20px;
  border-radius: 35px;
  border: 1px solid rgba(255, 255, 255, 0.5);
  border-right: 1px solid rgba(255, 255, 255, 0.2);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  font-size: 16px;
  letter-spacing: 1px;
  color: black;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.05);
}

.form .inputbox input::placeholder {
  color: white;
}

.form .inputbox input[type="submit"] {
  background: white;
  color: #666;
  max-width: 100px;
  cursor: pointer;
  margin-bottom: 20px;
  font-weight: 600;
}

.form .inputbox input[type="submit"]:hover {
  border-color: rgba(34, 230, 93, 0.5);
  background: #bae8c1;
  color: #40c057;
}

.form .inputbox input[type="submit"]:active {
  border-color: rgba(34, 230, 93, 0.5);
  background: #bae8c1;
  color: rgba(34, 230, 93, 0.5);
}

.forget {
  margin-top: 5px;
  color: white;
  cursor: default;
}

.forget a {
  color: white;
  font-weight: 600;
}

.forget a:hover {
  color: #40c057;
}

.forget a:active {
  color: rgba(34, 230, 93, 0.5);
}
</style>
