<template>
  <div class="choicecard">
    <div class="word">Word</div>
    <div class="options">
      <div class="option">Option 1</div>
      <div class="option">Option 2</div>
      <div class="option">Option 3</div>
      <div class="option">Option 4</div>
    </div>
    <div class="result"></div>
  </div>
</template>

<script>
export default {
  name: "choiceCard",
  props: {},
  mounted() {
    const showResult = (result, flag) => {
      const resultElement = document.createElement("div");
      resultElement.classList.add("result");
      if (flag == 0) {
        resultElement.classList.add("incorrect");
      } else {
        resultElement.classList.add("correct");
      }
      resultElement.innerHTML = result;

      const card = document.querySelector(".choicecard");
      // console.log(card);
      card.innerHTML = "";
      card.appendChild(resultElement);

      setTimeout(() => {
        showNextWord();
      }, 1500);
    };

    const showNextWord = () => {
      const randomWord = {};
      fetch("http://139.196.197.42:8085/EQuestion/random", {
        method: "GET",
      })
        .then((response) => response.json())
        .then((data) => {
          let choiceData = data.data;
          randomWord["word"] = choiceData.word;
          randomWord["answer"] = choiceData.answer;
          randomWord["options"] = [
            choiceData.option1,
            choiceData.option2,
            choiceData.option3,
            choiceData.option4,
          ];
          const randomOptions = randomWord.options.sort(
            () => 0.5 - Math.random()
          );

          const wordElement = document.createElement("div");
          wordElement.classList.add("word");
          wordElement.innerHTML = randomWord.word;

          const optionElements = randomOptions.map((option, index) => {
            const optionElement = document.createElement("div");
            optionElement.classList.add("option");
            optionElement.innerHTML = option;

            optionElement.addEventListener("click", () => {
              if (randomWord.options[index] === randomWord.answer) {
                // optionElement.classList.add("correct");
                showResult(
                  "<div class='font-box'><i class='icon iconfont icon-correct_2'></i></div>",
                  1
                );
              } else {
                // optionElement.classList.add("incorrect");
                showResult(
                  "<div class='font-box'><i class='icon iconfont icon-False_circle'</i></div>",
                  0
                );
              }
            });

            return optionElement;
          });

          const optionsElement = document.createElement("div");
          optionsElement.classList.add("options");
          optionElements.forEach((optionElement) =>
            optionsElement.appendChild(optionElement)
          );

          const card = document.querySelector(".choicecard");
          card.innerHTML = "";
          card.appendChild(wordElement);
          card.appendChild(optionsElement);
        });
    };

    showNextWord();
  },
};
</script>

<style scoped>
.choicecard {
  background-color: #40c057;
  border-radius: 10px;
  box-shadow: 0 24px 48px rgba(0, 0, 0, 0.075);
  padding: 20px;
  width: 100%;
  height: 70%;
  color: #fff;
  box-shadow: 0 24px 48px rgba(0, 0, 0, 0.075);
}
</style>

<style>
.word {
  font-size: 45px;
  font-weight: bold;
  margin-top: 20px;
  margin-bottom: 100px;

  text-align: center;
  background: linear-gradient(to bottom right, #fff, #8eff81);

  -webkit-background-clip: text;
  background-clip: text;

  color: transparent;
  height: 10%;
}

.options {
  display: flex;
  flex-wrap: wrap;
}

.option {
  width: 90%;
  margin-bottom: 10px;
  padding: 15px;
  background-color: #00b421;
  border-radius: 5px;
  cursor: pointer;
  border-radius: 10px;
  font-weight: 700;
  font-size: 18px;
}

.option:hover {
  background-color: #00b42183;
}

.question,
.options {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
  text-align: center;
  gap: 20px;
}

.result {
  /* margin-top: 20px; */
  font-weight: bold;
  width: 100%;
  height: 100%;
  /* padding: 20px; */
}

.result {
  display: flex;
  align-items: center;
  justify-content: center;
}
.result p {
  margin: 0;
  font-size: 4em;
}

.icon.icon-correct_2 {
  color: #00b421;
  font-size: 100px;
}

.icon.icon-False_circle {
  color: #ff000094;
  font-size: 100px;
}

.font-box {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
