<?php
    //お気に入り更新

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
    $food_favorite = $_GET["favorite"];

    $sql = "update food set favorite = ". $food_favorite ." where food_id = ". $food_id ."";
    $stm = $pdo->prepare($sql);
    $stm->execute();

    $sql = "select favorite from food where food_id = ". $food_id."";
    $stm = $pdo->prepare($sql);
    $stm->execute();
    $result = $stm->fetchAll(PDO::FETCH_ASSOC);
    return json_encode($result, JSON_PRETTY_PRINT);
?>