<?php
    //食品情報を更新

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
    $food_id = $_GET["food_id"];
    $food_name = $_GET["food_name"];
    $food_date = $_GET["food_date"];
    $date_select = $_GET["date_select"];
    $added_date = date('Y-m-d');
    $shop_name = $_GET["shop_name"];
    $food_number = $_GET["food_number"];

    $sql = "update food set food_name = '". $food_name ."', food_date = '". $food_date ."', date_select = ".$date_select .", added_date = '". $added_date."', shop_name = '". $shop_name ."', food_number = ".$food_number." where food_id = ".$food_id."";
    $stm = $pdo->prepare($sql);
    $stm->execute();

    $sql = "select * from food where food_id = ". $food_id."";
    $stm = $pdo->prepare($sql);
    $stm->execute();
    $result = $stm->fetchAll(PDO::FETCH_ASSOC);
    echo json_encode($result, JSON_UNESCAPED_UNICODE);
?>