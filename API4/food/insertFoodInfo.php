$sql = "insert into food (food_id, food_name, food_date, date_select, added_date, shop_name, food_number, category_id, favorite, user_id, food_image) select max(food_id) + 1, '". $food_name ."', ". $food_date .", ". $date_select .", ". $added_date .", '". $shop_name. "', ". $food_number .", ". $category_id ."," $favorite.", ". $user_id ." , '". $image_link."' from food";












<?php
    //食品情報を取得する

    //データベース接続
    $user = 'root';
    $dbname = 'food_management';
    $passwd = 'group7';
    $host = 'localhost';
    $dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";
    $pdo = new PDO($dsn, $user, $passwd);
    $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    //引数受け取り

　　$food_name = $_GET["food_name"];
　　$food_date = $_GET["food_date"];
　　$date_select = $_GET["date_select"];
　　$added_date = $_GET["added_date"];
　　$shop_name = $_GET["shop_name"];
　　$food_number = $_GET["food_number"];
　　$category_id = $_GET["category_id"];
　　$favorite = $_GET["favorite"];
　　$user_id = $_GET["user_id"];
　　$image_link = $_GET["image_link"];

　　//sql文
　　if ($food_name == null or $food_date == null or $added_date == null) {
        $result = ['result', false];
        return json_encode($result, JSON_UNESCAPED_UNICODE);
        exit();
    } else {
        $result = true;
        $sql = "insert into food (food_id, food_name, food_date, date_select, added_date, shop_name, food_number, category_id, favorite, user_id, food_image) select max(food_id) + 1, '". $food_name ."', ". $food_date .", ". $date_select .", ". $added_date .", '". $shop_name. "', ". $food_number .", ". $category_id ."," $favorite.", ". $user_id ." , '". $image_link."' from food";
    }

    $stm = $pdo->prepare($sql);
    $stm->execute();

    $sql = "select max(food_id) from food";
    $stm = $pdo->prepare($sql);
    $stm->execute();
　　$result2 = $stm->fetch(PDO::FETCH_ASSOC);
    $maxId = $result2['max(food_id)'];
    $maxId_json = json_encode($maxId, JSON_UNESCAPED_UNICODE);
    $arr = array('food_id' => $maxId_json, 'result' => "$result");
    return  json_encode($arr, JSON_UNESCAPED_UNICODE);
    echo json_encode($arr, JSON_PRETTY_PRINT);
?>