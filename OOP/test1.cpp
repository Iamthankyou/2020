#include <bits/stdc++.h>
using namespace std;
class rect{
private:
	double h,w;
public:
	rect():h(0),w(0){}
	rect(double h, double w):h(h),w(w){}

	friend ostream &operator << (ostream &out, rect &f){
		out << "Hinh chu nhat co chieu dai la " << f.h << " va chieu rong la " << f.w << "\n";
		return out;
	}
	
	friend istream &operator >> (istream &in, rect &f){
		cout << "Chieu dai: " ;
		in >> f.h;
		cout << "Chieu rong: " ;
		in >> f.w;

		return in; 
	}
	
	double s(){
		return w*h;
	}
	
	double getH(){
		return h;
	}
	
	double getW(){
		return w;
	}
};

int main(){
	rect *listRect;
	int n = 0;
	
	cout << "Nhap so hinh chu nhat: "; 	cin >> n;
	listRect= new rect[n];
	
	int resS = 0;
	int minS = INT_MAX;
	for (int i=0; i<n; i++){
		cout << "Nhap thong tin hinh chu nhat thu " << i+1 << ": " << "\n";
		cin >> listRect[i];
		resS += listRect[i].s();
		minS = minS>listRect[i].s()?listRect[i].s():minS;
	}
	
	cout << "Dien tich trung binh cua hinh chu nhat la: " << resS/n << "\n";
	cout << "Nhung hinh chu nhat co dien tich nho nhat  " << minS << " la :";
	
	for (int i=0; i<n; i++){
		if (listRect[i].s() == minS){
			cout << "(" << listRect[i].getH() << ", " << listRect[i].getW() << ") ";
		}
	} 
	
}
