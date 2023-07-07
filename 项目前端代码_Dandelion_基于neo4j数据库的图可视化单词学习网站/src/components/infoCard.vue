<template>
  <div class="word-card">
    <h2 class="word-card-title">{{ word }}</h2>
    <div class="info-area">
      <p class="word-card-cate">{{ cate }}</p>
      <p class="word-card-definition">
        {{ description }}
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "infoCard",
  props: {
    word: String,
    cate: String,
    description: String,
    // syn: String,
    // rel: String,
    // phr: String,
  },
};
</script>

<style scoped>
.word-card {
  background-color: #40c057;
  border-radius: 10px;
  box-shadow: 0 24px 48px rgba(0, 0, 0, 0.075);
  padding: 20px;
  width: 400px;
  height: 300px;
  color: #fff;
}
</style>

<style>
.word-card-title {
  font-size: 36px;
  font-weight: bold;
  margin-top: 10px;
  margin-bottom: 15px;

  text-align: center;
  background: linear-gradient(to bottom right, #fff, #8eff81);

  -webkit-background-clip: text;
  background-clip: text;

  color: transparent;
}

.word-card-cate {
  font-size: 24px;
  font-weight: bold;
  text-align: center;
  margin-bottom: 40px;
  /* 设置渐变背景 */
  background: linear-gradient(to bottom right, #fff, #8eff81);

  -webkit-background-clip: text;
  background-clip: text;

  color: transparent;
}

.itemer-title {
  font-weight: bold;
}

.word-card-definition {
  font-weight: 500;
  text-align: center;
  font-size: 24px;
  font-family: "华文中宋", sans-serif;
  color: #c7ffd1;
}

.word-card-synonyms {
  list-style: none;
  margin: 0;
  padding: 0;
}

.word-card-root-words {
  list-style: none;
  /* margin: 16px 0 0 0; */
  padding: 0;
}

.word-card-phrases {
  list-style: none;
  /* margin: 16px 0 0 0; */
  padding: 0;
}

.word-card-synonyms-item,
.word-card-root-words-item,
.word-card-phrase-item {
  font-size: 14px;
  /* line-height: 1.4; */
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.word-info-details {
  display: flex;
  justify-content: space-between;
}
</style>
