document.addEventListener("DOMContentLoaded", () => {
  const fileInput = document.querySelector("input.file");
  const prevImg = document.querySelector("img.gallery");
  const imgBorderBox = document.querySelector("div.image");
  const base64Box = document.querySelector("textarea.base64");

  /*
  업로드할 이미지를 base64 방식으로 encoding 하는 함수
  base64 제약사항
  파일 크기가 상당히 크다.
  jpeg는 그래도 다소 다소 양호하나 png나 백터 타입은 여러가지 이슈가있다.
  파일의 크기문제로 업로드, DB 저장등에서 문제를일으킬 수 있다.
  다만 , DB에 파일을 저장함으로써 별도의 이미지를 보관하는 방식에 비해 다소 유리한 점도 있다.

  base64 로 변환된 파일을 압축하여 jpeg로 변환하면 용량문제를 다소 해결할 수 있다.
  */

  const ecodeImageFileAsBase64 = async (image) => {
    return new Promise((resolve, _) => {
      const reader = new FileReader();
      reader.onloadend = () => {
        const myImage = new Image();
        const imageBase64 = reader.result;
        myImage.src = imageBase64;

        myImage.onload = (e) => {
          /* 이미지 객체(myimage) 에 이미지가 load되면 
          화면에 2d 가상 canvas를 생성하고 
          그 canvas에 myImage에 담긴 이미지를 그려라.
          */
          const myCanvas = document.createElement("canvas");
          const context = myCanvas.getContext("2d");
          // 그려줄 이미지 크기만큼 canvas크기 지정하기
          myCanvas.width = e.target.width;
          myCanvas.height = e.target.height;
          context.drawImage(e.target, 0, 0);

          // canvas에 그려진 이미지를  jpeg 로 변환하고 크기를 0.5
          let point = 0.5;
          let reSizeImage = myCanvas.toDataURL("image/jpeg", point);
          const imageSize = 2 * 1024 * 1024; //2MB

          //압축한 이미지 크기가 2m 보다 크면  계속 일정 비율만큼 압축 실행하기
          while (reSizeImage.length > imageSize) {
            if (point < 0.01) {
              break;
            }
            point -= 0.1;
            reSizeImage = myCanvas.toDataURL("image/jpeg", point);
          }
          if (reSizeImage.length > imageSize) {
            alert("이미지가 너무 큽니다. 업로드 할 수 없습니다.");
            return false;
          }
          resolve(reSizeImage);
        };

        // resolve(reader.result);
      };
      reader.readAsDataURL(image);
    });
  };

  prevImg.addEventListener("click", () => fileInput.click());

  imgBorderBox.addEventListener("paste", async (e) => {
    const items = e.clipboardData.items;
    //items 객체가 존재하면 그중 0번째 요소를 getter 하라.
    const item = items?.[0];
    // image/png, text/plan, application/text,
    // 붙여넣기 한 데이터가 image/* 이면~~
    if (item.type.indexOf("image") === 0) {
      // 붙여넣기 한 이미지 중에서 파일만 추출하기
      const blob = item.getAsFile();

      // 파일이 추출이 안되면
      if (!blob) {
        return null;
      }

      const base64 = await ecodeImageFileAsBase64(blob);
      prevImg.src = base64;
      base64Box.value = base64;
      //   //파일읽기
      //   const reader = new FileReader();
      //   //다읽었니?
      //   reader.onloadend = () => {
      //     prevImg.src = reader.result;
      //   };
      //   reader.readAsDataURL(blob);
    } else {
      alert("이미지만 붙여넣기 하세요.");
    }
  });

  fileInput.addEventListener("change", async (e) => {
    const target = e.target;
    const file = target.files(0);

    const base64 = await ecodeImageFileAsBase64(file);
    prevImg.src = base64;
    base64Box.value = base64;
  });
});
