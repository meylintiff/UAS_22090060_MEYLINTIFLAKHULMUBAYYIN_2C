import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

    public class JSONDataFetcher {

        public static void main(String[] args) {
            String urlString = "https://dummyjson.com/products/category/smartphones";
            String xConsId = "harber123";
            String xUserKey = "_tabC4XbR";

            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("X-Cons-ID", xConsId);
                connection.setRequestProperty("X-userkey", xUserKey);

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                    String json = response.toString();
                    System.out.println("JSON Data: " + json);

                    // Di sini, Anda perlu mengubah kode berikut sesuai dengan struktur data JSON Anda
                    // untuk mendapatkan array elemen yang ingin diurutkan
                    int[] dataArray = {5, 2, 8, 1, 9};

                    selectionSort(dataArray);

                    System.out.println("Sorted Data: " + Arrays.toString(dataArray));
                } else {
                    System.out.println("Error: " + responseCode);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void selectionSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

