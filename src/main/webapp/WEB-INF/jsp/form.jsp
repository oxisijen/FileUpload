<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>アップロードテスト</title>
</head>
<body>
	<form action="/FileUpload/form" method="post" enctype="multipart/form-data">
	名前:<input type="text" name="name"><br>
	写真:<input type="file" name="pict"  accept="image/*" onchange="previewFile(this);"><br>
<button type="submit">送信</button>
</form>

  <p>プレビュー</p>
  <img id="preview">
 
 
  <script>
  function previewFile(hoge){
    var fileData = new FileReader();
    fileData.onload = (function() {
      //id属性が付与されているimgタグのsrc属性に、fileReaderで取得した値の結果を入力することで
      //プレビュー表示している
      document.getElementById('preview').src = fileData.result;
    });
    fileData.readAsDataURL(hoge.files[0]);
  }
  </script>

</body>
</html>