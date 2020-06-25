//
//  BOJ_.swift
//  Algorithm
//
//  Created by Theodore's iMac on 2020/06/23.
//  Copyright © 2020 Sample. All rights reserved.
//

import Foundation

class BOJ_1330 {
    public func solve() {
        var a = readLine()
        
        if let a = a {
            
            let array = a.components(separatedBy: " ")
            
            let first: Int = Int(array[0])!
            let second: Int = Int(array[1])!
            
            if first > second {
                print(">")
            } else if array[0] == array[1] {
                print("==")
            } else {
                print("<")
            }
        }
    }
}
