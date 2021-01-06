//
//  ViewController.swift
//  IosRestTestApp
//
//  Created by iblis on 06/01/2021.
//

import UIKit
import Alamofire

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        let network = QuotationServiceAPI()
        guard let url = URL(string: "http://localhost:8080/authors") else {
            return
        }
        network.execute(url) {(json, error) in
            if let error = error {
                print("EERROR \(error)")
            }
            else if let json = json {
                do {
                    let jsonData = try JSONSerialization.data(withJSONObject: json)
                    let decoderdec = JSONDecoder()
                    decoderdec.keyDecodingStrategy = .convertFromSnakeCase
                    let arrSports = try decoderdec.decode([Author].self, from: jsonData)
                    print(arrSports)
                } catch let error {
                    print(error)
                }
            }
        }
    }


}

