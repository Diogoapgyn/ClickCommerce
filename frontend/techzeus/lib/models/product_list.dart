import 'dart:convert';
import 'dart:math';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
//import 'package:techzeus/data/dummy_data.dart';
import 'package:techzeus/models/product.dart';
//import 'package:techzeus/utils/constants.dart';

class ProductList with ChangeNotifier {
  final _baseUrl = "http://192.168.1.20:8080/produtos/listar";
  final _Url = "http://192.168.1.20:8080/produtos";

  //final List<Product> _items = dummyProducts;
  List<Product> _items = [];

  List<Product> get items => [..._items];
  List<Product> get favoriteItems =>
      _items.where((prod) => prod.isFavorite).toList();

  int get itemsCount {
    return _items.length;
  }

  Future<void> saveProduct(Map<String, Object> data) {
    bool hasId = data['id'] != null;

    final product = Product(
      id: hasId ? data['id'] as String : Random().nextDouble().toString(),
      name: data['name'] as String,
      description: data['description'] as String,
      price: data['price'] as double,
      imageUrl: data['imageUrl'] as String,
    );
    //print(data);
    if (hasId) {
      print(data);
      return updateProduct(product);
      //addProduct(product);
    } else {
      return addProduct(product);
    }
  }

  /* Future<void> loadProducts() async {
    final response = await http.get(Uri.parse(_baseUrl));
    Map<String, dynamic> data = jsonDecode(response.body);
    data.forEach((productId, productData) {
      _items.add(
        Product(
          id: productData['id'],
          name: productData['name'],
          description: productData['description'],
          price: productData['price'],
          imageUrl: productData['imageUrl'],
          isFavorite: productData['isFavorite'],
        ),
      );
    });
    notifyListeners();
  }
 */
  Future<void> loadProducts() async {
    final response = await http.get(Uri.parse(_baseUrl));
    List<dynamic> data = jsonDecode(response.body);
    //print(data);

    _items = data
        .map((productData) => Product(
              id: productData['id'].toString(),
              name: productData['name'] as String,
              description: productData['description'] as String,
              price: productData['price'] as double,
              imageUrl: productData['imageUrl'] as String,
              isFavorite: productData['isFavorite'] ?? false,
            ))
        .toList();

    notifyListeners();
  }

  Future<void> addProduct(Product product) async {
    final future = http.post(
      Uri.parse('$_Url/inserir'),
      headers: {"Content-Type": "application/json"},
      body: jsonEncode(
        {
          "name": product.name,
          "description": product.description,
          "price": product.price,
          "imageUrl": product.imageUrl,
          "isFavorite": product.isFavorite,
        },
      ),
    );

    future.then((response) {
      //print(jsonDecode(response.body));
      final id = jsonDecode(response.body)['name'];
      _items.add(Product(
        id: id,
        name: product.name,
        description: product.description,
        price: product.price,
        imageUrl: product.imageUrl,
        isFavorite: product.isFavorite,
      ));
      notifyListeners();
    });
  }

  Future<void> updateProduct(Product product) async {
    int index = _items.indexWhere((p) => p.id == product.id);

    if (index >= 0) {
      await http.patch(
        Uri.parse('$_Url/${product.id}'),
        headers: {"Content-Type": "application/json"},
        body: jsonEncode(
          {
            "name": product.name,
            "description": product.description,
            "price": product.price,
            "imageUrl": product.imageUrl,
            //"isFavorite": product.isFavorite,
          },
        ),
      );
      _items[index] = product;
      notifyListeners();
    }
  }

  Future<void> removeProduct(Product product) async {
    int index = _items.indexWhere((p) => p.id == product.id);

    if (index >= 0) {
      await http.delete(
        Uri.parse('$_Url/${product.id}'),
      );
      _items.removeWhere((p) => p.id == product.id);
      notifyListeners();
    }
  }
}

// bool _showFavoriteOnly = false;

//   List<Product> get items {
//     if (_showFavoriteOnly) {
//       return _items.where((prod) => prod.isFavorite).toList();
//     }
//     return [..._items];
//   }

//   void showFavoriteOnly() {
//     _showFavoriteOnly = true;
//     notifyListeners();
//   }

//   void showAll() {
//     _showFavoriteOnly = false;
//     notifyListeners();
//   }
