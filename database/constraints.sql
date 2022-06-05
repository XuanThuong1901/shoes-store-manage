create trigger thaydoittdonhang 
on donhang
after insert, update
as
begin
	declare @trangthai int
	declare @manv varchar(15)

	select @trangthai = inserted.TinhTrangDonHang, @manv = inserted.MaNV from inserted
	if(@manv is null and @trangthai != 1)
	begin
		rollback tran
	end

	if(@manv is not null and @trangthai = 1)
	begin
		rollback tran
	end

end

alter trigger trusltonkhitaodonhang
on chitietdonhang
after insert,update
as
begin
	declare @mactsp int
	declare @soluong int
	declare @soluongupdate int

	declare cursorctsp cursor for select MaCTSP, SoLuong from inserted

	open cursorctsp

	fetch next from cursorctsp into @mactsp, @soluong
	while @@FETCH_STATUS = 0
	begin
		select @soluongupdate = CHITIETSANPHAM.SoLuong from CHITIETSANPHAM where CHITIETSANPHAM.MaChiTietSP = @mactsp
		if(@soluongupdate < @soluong )
		begin
			rollback tran
			
		end
		else if(@soluongupdate >= @soluong)
		begin
			set @soluongupdate =  @soluongupdate - @soluong
			update CHITIETSANPHAM set SoLuong = @soluongupdate where MaChiTietSP = @mactsp	
		end
		
		fetch next from cursorctsp into @mactsp, @soluong
	end

	close cursorctsp
	deallocate curstorctsp
	
end