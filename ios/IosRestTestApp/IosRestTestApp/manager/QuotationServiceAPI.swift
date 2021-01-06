//
//  NetworkManager.swift
//  IosRestTestApp
//
//  Created by iblis on 06/01/2021.
//

import Foundation
import Alamofire

class QuotationServiceAPI {
    typealias RestResponse = ([[String: Any]]?, Error?) -> Void
    
    // @escaping because it could be called much later than it is provided to func.
    func execute(_ url: URL, callbac: @escaping RestResponse){
        // https://stackoverflow.com/questions/32631184/the-resource-could-not-be-loaded-because-the-app-transport-security-policy-requi
        
        AF.request(url).validate().responseJSON{ response in
            
            if let error = response.error {
                callbac(nil, error)
            } else if let jsonArray = response.value as? [[String: Any]]{
                callbac(jsonArray, nil)
            } else if let jsonDict = response.value as? [String: Any]{
                callbac([jsonDict], nil)
            }
        }
    }
}
