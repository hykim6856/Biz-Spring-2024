document.addEventListener("DOMContentLoaded", () => {
  const preImg = document.querySelector("img.represent");
  const imageInput = document.querySelector("#files");
  const thumnailBox = document.querySelector("div.thumnail");

  preImg.addEventListener("click", () => imageInput.click());

  const imgPreview = (file, target) => {
    const reader = new FileReader();
    reader.onloadend = (e) => (target.src = e.target.result);
    reader.readAsDataURL(file);
  };

  imageInput.addEventListener("change", (e) => {
    const files = e.target.files;
    const file = files[0];
    imgPreview(file, preImg);

    thumnailBox.innerHTML = "";
    for (let i = 1; i < files.length; i++) {
      const tempImage = document.createElement("img");
      imgPreview(files[i], tempImage);
      thumnailBox.appendChild(tempImage);
    }
  });

  thumnailBox.addEventListener("click", (e) => {
    const thumImage = e.target;
    preImg.src = thumImage.src;
  });
});
