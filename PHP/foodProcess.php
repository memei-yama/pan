<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>foodProcess</title>
</head>
<body>
<?php
//画像データを受け取り、文字認識を行うメソッド
function readDate($image_data){
    //処理
    return $food_date;
}

//食品情報取得
function getFood($user_id){
    list(
        $food_id, $food_name, $food_date, $date_select, $added_date, 
        $shop_name, $food_number, $category_id, $favorite, $image_rink
    ) = foodDB.getFood();
//画像ファイルリンクから画像データと画像名を取得
    return array($food_id, $food_name, $food_date, $date_select, $added_date, 
    $shop_name, $food_number, $category_id, $favorite, $image_data, $image_name);
}

//カテゴリー情報取得
function getCategory{
    list ($category_id, $category_name) = foodDB.getCategory();
    return array($category_id, category_name);
}

//食品登録
function addFood($food_name, $food_date, $date_select, $added_date, $shop_name, $food_number, $category_id){
    $food_id = foodDB.addFood($food_name, $food_date, $date_select, $added_date, $shop_name, $food_number, $category_id);
    return $food_id;
}

//食品更新
function registerFood($food_id, $food_name, $food_date, $date_select, $shop_name, $food_number, $category_id, $image_data, $image_name){
    //画像データと画像名をサーバに保存
    //画像ファイルリンクの取得
    foodDB.registerFood($food_id, $food_name, $food_date, $date_select, $shop_name, $food_number, $category_id, $image_rink)
}

//食品削除
function deleteFood($food_id){
    foodDB.registerFood($food_id);
}

//削除モード（個数一括調整）
//お気に入り登録
function favoriteFood($food_id){
    $favorite = foodDB.favoriteFood($food_id)
    return $favorite;
}
?>
</body>
</html>