## 📚 書籍管理アプリケーション

このアプリケーションはSpring Bootを使用した書籍管理アプリケーションです。
書籍をGoogle Books APIを使用して検索して、書籍を選択し登録します。

登録した書籍ごとに読書ステータスを設定でき、未読、読書中、読了の3つから選び設定します。

書籍管理から必要がなくなった書籍は削除できます。削除する際削除してもよいか確認を促すモーダルが表示されます。

![GIF](https://private-user-images.githubusercontent.com/63445556/424501773-ef248761-7d3d-4014-9c3b-13fcfa26320b.gif?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDIzOTE5NjMsIm5iZiI6MTc0MjM5MTY2MywicGF0aCI6Ii82MzQ0NTU1Ni80MjQ1MDE3NzMtZWYyNDg3NjEtN2QzZC00MDE0LTljM2ItMTNmY2ZhMjYzMjBiLmdpZj9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNTAzMTklMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjUwMzE5VDEzNDEwM1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWQzYjAyNTg5OGMwYzdhY2I5OTdkOTk5MzNjZDI5ZGVlNDMwODNlYjIwMDUzNWRlYTZiYWNlMjY1ZTMxOWY5ZjMmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.vV0nIOXKlMYAE8i_MPvW6VQkMUn9j5pxIsYVVetIhgw)

## 🛠 使用技術
| 技術 | 説明 |
| ------ | ------|
| **Java** | メインのプログラム言語|
| **Spring Boot** | バックエンドフレームワーク |
| **PostgreSQL** | データベース |
| **JPA (Hibernate)** | ORマッパー |
| **Thymeleaf** | フロントエンド |
| **Bootstrap** | スタイリング・レスポンシブ対応 |
| **Gradle** | ビルドツール |
| **WebClient** | 外部APIとの連携 (Google Books API) |
| **Docker** | コンテナ化対応 |

## 📌 主な機能

✅ **書籍検索** (Google Books API)  
✅ **書籍の登録・削除** (PostgreSQL に保存)  
✅ **読書ステータス管理** (未読・読書中・読了)  
✅ **積読の可視化** (データ分析) 

## 🚀 セットアップ方法

1. **環境構築**
   ```sh
   git clone https://github.com/your-repo.git
   cd your-repo

2. **データベース設定(PostgreSQL)**
    ```sh
    docker-compose up -d

3. アプリの実行
    ```sh
   ./gradlew bootRun