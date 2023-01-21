<?php
    //投稿をDBに登録する

    $user = 'root';
    $dbname = 'food_management';
    $passwd = 'group7';
    $host = 'localhost';
    $dsn = "mysql:host={$host};dbname={$dbname};charset=utf8";
    $pdo = new PDO($dsn, $user, $passwd);
    $pdo->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    $user_id = $_GET["user_id"];
    $food_id = $_GET["food_id"];
    $send_date = date('Y-m-d');
    $char_body = $_GET["char_body"];
    $image_link = $_GET["image_link"];

    $sql = "insert into timeline (timeline_id, user_id, food_id, send_post_date, post_body, image_link) select max(timeline_id) + 1, ".$user_id.", ".$food_id.", '".$send_date."', '".$char_body."', '". $image_link."' from timeline";
    $stm = $pdo->prepare($sql);
    $stm->execute();

    $sql = "select max(timeline_id) from timeline";
    $stm = $pdo->prepare($sql);
    $stm->execute();
    $result = $stm->fetchAll(PDO::FETCH_ASSOC);

    echo json_encode($result, JSON_PRETTY_PRINT);
?>