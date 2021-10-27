#include <bits/stdc++.h>
using namespace std;
class student{
private:
	string name;
	double point;
public:
	student():name(""),point(0){}
	student(string n, double p):name(n),point(p){};
	
	friend istream &operator >> (istream &in, student &f){
		cout << "Ten sinh vien : "; fflush(stdin); getline(in,f.name);
		cout << "So diem: "; in >> f.point   ;
	}
	
	friend ostream &operator << (ostream &out, student &f){
		out << "Ten sinh vien: " << f.name << ", diem so:  " << f.point << "\n";
		return out;
	}

	void out(){
		cout << "Ten sinh vien: " << name << ", diem so:  " << point << "\n";
	}

	void in(){
		cout << "Ten sinh vien : "; fflush(stdin); getline(cin,name);
		cout << "So diem: "; cin >> point   ;
	}

	string getName(){
		return name;
	}
	
	double getPoint(){
		return point;
	}
};

class olympic:public student{
private:
	string school;
public:
	olympic():student(),school(""){};
	olympic(string n, double p, string s):student(n,p),school(s){};
	
	void inO(){
		in();
		cout << "Nhap ten truong (A, B, C) : "; fflush(stdin); getline(cin,school);
	}
	
	void outO(){
		out();
		cout << "Ten truong: " << school << "\n";
	}
	
	string getSchool(){
		return school;
	}
};

int main(){
	int n;
	olympic *listOlympic;
	cout << "Nhap so thi sinh: "; cin >> n;
	listOlympic = new olympic[n];
	int dA=0, dB=0, dC=0;
	int cA=0, cB=0, cC=0;
	
	for (int i=0; i<n; i++){
		cout << "Nhap thong tin sinh vien thu " << i+1 << ": \n";
		listOlympic[i].inO();
		if (listOlympic[i].getSchool() == "A"){
			dA+=listOlympic[i].getPoint();
			cA++;
		}
		else if (listOlympic[i].getSchool() == "B"){
			dB+=listOlympic[i].getPoint();
			cB++;
		}
		else{
			dC+=listOlympic[i].getPoint();
			cC++;
		}
	}
	
	cout << "Tong diem moi truong A, B, C lan luot la : "<< dA << " " << dB << " " << dC << "\n";
	if (dA>dB && dA>dC){
		cout << "Truong A co diem cao nhat";
	}
	else if (dB>dC){
		cout << "Truong B co nhieu cao nhat";
	}
	else{
		cout << "Truong C co diem cao nhat";
	}
	
	cout << "So sinh vien tham du truong A: " << cA << "\n";	
	cout << "So sinh vien tham du truong B: " << cB << "\n";
	cout << "So sinh vien tham du truong C: " << cC << "\n";

}
